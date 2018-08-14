package com.mnd.sample;


import io.proximax.xpx.facade.download.Download;
import io.proximax.xpx.facade.download.DownloadException;
import io.proximax.xpx.facade.download.DownloadFileResult;
import io.proximax.xpx.facade.download.DownloadParameter;
import java.io.File;
import java.io.IOException;

public class DownloadTest extends establishConnection{

    private static final String downloadHash = "4fd3ac81f7f7dcdcf897803745e26b6c8b7bf471bfbf0dc73f9f4b838303b275";

    public static void main(String[] args) throws IOException, DownloadException {
        //initialize the download
        final Download download = new Download(remotePeerConnection);

        //downloads the file
        final DownloadFileResult result = download.downloadFile(DownloadParameter.create()
                .nemHash(downloadHash).build());

        //saves the downloaded result to a directory
        final File downloadedFile = new File("d:/downloadedFile/file1.txt");
        result.saveToFile(downloadedFile);

    }
}



