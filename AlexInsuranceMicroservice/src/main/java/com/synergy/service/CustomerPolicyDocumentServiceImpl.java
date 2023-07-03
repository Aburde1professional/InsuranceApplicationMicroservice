package com.synergy.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.synergy.domain.PolicyDocuments;
import com.synergy.repository.CustomerPolicyDocumentsRepository;
import com.synergy.ImageUtil;

@Service
public class CustomerPolicyDocumentServiceImpl {
	
	@Autowired
    private CustomerPolicyDocumentsRepository customerPolicyDocumentsRepository;
	
	public PolicyDocuments uploadImage(MultipartFile file) throws IOException {
		PolicyDocuments pImage = new PolicyDocuments();
		pImage.setName(file.getOriginalFilename());
		pImage.setType(file.getContentType());
		pImage.setPolicyDocumentData(ImageUtil.compressImage(file.getBytes()));
		return customerPolicyDocumentsRepository.save(pImage);
	}
	
	public byte[] downloadPolicyDocuments(String fileName){
        Optional<PolicyDocuments> imageData = customerPolicyDocumentsRepository.findByName(fileName);
        return ImageUtil.decompressImage(imageData.get().getPolicyDocumentData());
    }
}
