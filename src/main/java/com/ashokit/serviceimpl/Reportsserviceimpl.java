package com.ashokit.serviceimpl;

import java.io.File;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ashokit.entity.Citizen;
import com.ashokit.entity.Document;
import com.ashokit.repo.CitizenRepos;
import com.ashokit.repo.DocumentRepo;
import com.ashokit.service.ReportsService;
import com.ashokit.utility.PdfGenerator;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class Reportsserviceimpl implements ReportsService {

	@Autowired
	private PdfGenerator pdfgen;

	@Autowired
	private CitizenRepos citizenrepo;

	@Autowired
	private S3Client s3Client;

	@Autowired
	private DocumentRepo docrepo;
	
	
	 @Value("${application.bucket.name}")
	    private String bucketName;

	public String pdfexport(Integer id) throws Exception {
		// TODO Auto-generated method stub

		Optional<Citizen> findById = citizenrepo.findById(id);
		if (findById.isPresent()) {
			Citizen entity = findById.get();

			String key =  "citizen data"+entity.getCitizenId().toString()   + ".pdf";

			File f = new File(key);

			byte[] generatePdf = pdfgen.generatePdf(id, entity);

			String bucketName = "venkats3b";

			PutObjectRequest putObjectRequest = PutObjectRequest.builder().bucket(bucketName).key(f.getName()).build();

			s3Client.putObject(putObjectRequest, RequestBody.fromBytes(generatePdf));

			String objectUrl = s3Client.utilities().getUrl(builder -> builder.bucket(bucketName).key(key))
					.toExternalForm();

			Document doc = new Document();
			doc.setDocumentId(entity.getCitizenId());
			doc.setDocumentUrl(objectUrl);

			docrepo.save(doc);

			return "pdf uploaded successfully..";

		}

		return "problem occured..";

	}
}
