package com.greco.imagetag.bus;

import com.greco.imagetag.model.ObjectKey;
import com.greco.imagetag.repo.DetectedLabelRepository;
import com.greco.imagetag.repo.ObjectKeyLabelRepository;
import com.greco.imagetag.repo.ObjectKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ObjectKeyManager {

    @Autowired
    private DetectedLabelRepository detectedLabelRepository;

    @Autowired
    private ObjectKeyRepository objectKeyRepository;

    @Autowired
    private ObjectKeyLabelRepository objectKeyLabelRepository;

    @Transactional
    public void saveObjectKeyAndLabels(ObjectKey objectKey){
        int objectKeyId = objectKeyRepository.addObjectKey(objectKey);
        objectKey.getDetectedLabels().forEach(label->{
            int detectedLabelId = detectedLabelRepository.addDetectedLabel(label);
            objectKeyLabelRepository.addLabelAndConfidenceForObjectKey(objectKeyId,detectedLabelId,label.getConfidence());
        });

    }
}
