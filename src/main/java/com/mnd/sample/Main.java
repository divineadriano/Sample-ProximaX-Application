package com.mnd.sample;

import io.proximax.xpx.exceptions.ApiException;
import io.proximax.xpx.facade.download.*;
import io.proximax.xpx.facade.search.Search;
import io.proximax.xpx.facade.upload.Upload;
import io.proximax.xpx.facade.upload.UploadException;
import io.proximax.xpx.model.ResourceHashMessageJsonEntity;
import org.pmw.tinylog.Logger;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Main extends establishConnection{

    private static final String KEYWORDS_PLAIN_AND_FILE = "smm,file";
    private static Upload upload;
    private static Download download;

    private static final String TEST_PRIVATE_KEY = "5b10e4dcffabf810e04f1cf9473c728ff9ae2bf563521de61d7c0feeea47f1ea";
    private static final String TEST_PUBLIC_KEY = "1f0921d41f17e87fb07026ff11f62030412ed8bf42723eaa929055b837608260";
    //private static final Map<String, String> METADATA_AS_MAP = singletonMap("Author Name", "Jose Rizal");



    public static final Map<String, String> METADATA_AS_MAP = fileToPlainMessageNemHashMap();

    private static Map<String, String> fileToPlainMessageNemHashMap() {
        final HashMap<String, String> map = new HashMap<>();
        map.put("Author Name", "Jose Rizal");
        map.put("Year Published", "2016");
        return map;
    }

    private static File filePath;
    private static String uploadhash="";

    public static void main(String[] args) throws IOException, UploadException {



        final myFirstApplication tryupload = new myFirstApplication();
        tryupload.txtFilePath.setText("c:/...");



        tryupload.btnselect.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);

                int rVal = fileChooser.showOpenDialog(null);
                if (rVal == JFileChooser.APPROVE_OPTION) {
                    tryupload.txtFilePath.setText(fileChooser.getSelectedFile().toString());
                }
            }
        });


        /*
         tryupload.path = fileChooser.getSelectedFile().toString();


                    filePath = new File(tryupload.path);
                    try {

                        upload = new Upload(remotePeerConnection);

                        UploadFileParameter parameter = UploadFileParameter.create()
                                .senderPrivateKey(TEST_PRIVATE_KEY)
                                .receiverPublicKey(TEST_PUBLIC_KEY)
                                .file(filePath)
                                .contentType("PDF")
                                .keywords(KEYWORDS_PLAIN_AND_FILE)
                                .metadata(METADATA_AS_MAP)
                                .build();

                        final UploadResult uploadResult;

                        uploadResult = upload.uploadFile(parameter);
                        /*Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        String jsonOutput = gson.toJson(uploadResult.getDataMessage());
                        System.out.println(jsonOutput);

        uploadhash = uploadResult.getNemHash();
        System.out.println("Nem Hash: " + uploadResult.getNemHash());
        System.out.println("IPFS Hash: " + uploadResult.getDataMessage().hash());
        System.out.println("digest: " + uploadResult.getDataMessage().digest());
        System.out.println("name: " + uploadResult.getDataMessage().name());
        System.out.println("type: " + uploadResult.getDataMessage().type());
        System.out.println("keywords: " + uploadResult.getDataMessage().keywords());
        System.out.println("metadata: " + uploadResult.getDataMessage().metaData());




    } catch (UploadException e1) {
        e1.printStackTrace();
    } catch (IOException e1) {
        e1.printStackTrace();
    }
         */


        tryupload.btndownload.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                try {
                    System.out.println(uploadhash);
                    download = new Download(remotePeerConnection);

                    final DownloadFileResult result = download.downloadFile(DownloadParameter.create()
                            .nemHash("4fd3ac81f7f7dcdcf897803745e26b6c8b7bf471bfbf0dc73f9f4b838303b275").build());

                    final File downloadedFile = new File("d:/downloadedFile/file1.txt");
                    result.saveToFile(downloadedFile);


                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (DownloadException e1) {
                    //tryupload.lbldownload.setText(emptyList().toString());
                    e1.printStackTrace();
                }


            }
        });

        tryupload.btnsearch.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {



                try {
                    Search search = new Search(remotePeerConnection);
                    final List<ResourceHashMessageJsonEntity> result = search.searchByKeyword(TEST_PRIVATE_KEY, TEST_PUBLIC_KEY, "marketing");
                    Logger.info(result.size());
                    System.out.println(result);

                } catch (ApiException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                } catch (ExecutionException e1) {
                    e1.printStackTrace();
                }


            }
        });








    }
}
