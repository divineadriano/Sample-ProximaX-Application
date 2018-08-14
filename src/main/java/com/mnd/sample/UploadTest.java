package com.mnd.sample;

import io.proximax.xpx.facade.upload.Upload;
import io.proximax.xpx.facade.upload.UploadException;
import io.proximax.xpx.facade.upload.UploadFileParameter;
import io.proximax.xpx.facade.upload.UploadResult;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UploadTest extends establishConnection{



    private static final String SENDER_PRIVATE_KEY = "5b10e4dcffabf810e04f1cf9473c728ff9ae2bf563521de61d7c0feeea47f1ea";
    private static final String RECEIVER_PUBLIC_KEY = "1f0921d41f17e87fb07026ff11f62030412ed8bf42723eaa929055b837608260";
    private static final String FILE_PATH = "src//main//resources//test_pdf_file_v1.pdf";
    private static final String KEYWORDS = "book,marketing";

    private static final Map<String, String> METADATA = fileToPlainMessageNemHashMap();

    private static Map<String, String> fileToPlainMessageNemHashMap() {
        final HashMap<String, String> map = new HashMap<>();
        map.put("Author Name", "Jose Rizal");
        map.put("Year Published", "2016");
        return map;
    }

    //private static final Map<String, String> METADATA_AS_MAP = singletonMap("Author Name", "Jose Rizal");





    public static void main(String[] args) throws IOException, UploadException {

        final Upload upload = new Upload(remotePeerConnection);

        UploadFileParameter parameter = UploadFileParameter.create()
                .senderPrivateKey(SENDER_PRIVATE_KEY)
                .receiverPublicKey(RECEIVER_PUBLIC_KEY)
                .file(new File(FILE_PATH))
                .keywords(KEYWORDS)
                .metadata(METADATA)
                .build();

        final UploadResult uploadResult;
        uploadResult = upload.uploadFile(parameter);

        System.out.println("Nem Hash: " + uploadResult.getNemHash());
        System.out.println("IPFS Hash: " + uploadResult.getDataMessage().hash());
        System.out.println("digest: " + uploadResult.getDataMessage().digest());
        System.out.println("name: " + uploadResult.getDataMessage().name());
        System.out.println("type: " + uploadResult.getDataMessage().type());
        System.out.println("keywords: " + uploadResult.getDataMessage().keywords());
        System.out.println("metadata: " + uploadResult.getDataMessage().metaData());

    }
}


