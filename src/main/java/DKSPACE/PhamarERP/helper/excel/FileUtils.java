package DKSPACE.PhamarERP.helper.excel;

import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Slf4j
public final class FileUtils {
    private FileUtils() {
    }

    public static byte[] compress(MultipartFile file) {
        try {
            return compress(file.getBytes());
        } catch (IOException e) {
            log.error("FileUtils compressFile error: ", e);
            throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
        }
    }

    private static byte[] compress(byte[] data) throws IOException {
        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4 * 1024];
        while (!deflater.finished()) {
            int size = deflater.deflate(tmp);
            outputStream.write(tmp, 0, size);
        }
        try {
            outputStream.close();
        } catch (Exception ignored) {
        }
        return outputStream.toByteArray();
    }


    public static byte[] decompress(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4 * 1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(tmp);
                outputStream.write(tmp, 0, count);
            }
            outputStream.close();
        } catch (Exception ignored) {
        }
        return outputStream.toByteArray();
    }



    public static String generateFileName(MultipartFile file) {

        return null;
    }
}
