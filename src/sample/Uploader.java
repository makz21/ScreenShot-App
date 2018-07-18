package sample;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import javax.xml.bind.DatatypeConverter;

public class Uploader {
    public static final String UPLOAD_API_URL = "https://api.imgur.com/3/image";
    //public static final int MAX_UPLOAD_ATTEMPTS = 3;
    private final static String CLIENT_ID = "1e8aeb7483acd32";

    public static String upload(File file)
    {
        HttpURLConnection conn = getHttpConnection(UPLOAD_API_URL);
        writeToConnection(conn, "image=" + toBase64(file));
        return getResponse(conn);
    }

    private static String toBase64(File file)
    {
        try
        {
            byte[] b = new byte[(int) file.length()];
            FileInputStream fs = new FileInputStream(file);
            fs.read(b);
            fs.close();
            return URLEncoder.encode(DatatypeConverter.printBase64Binary(b), "UTF-8");
        }
        catch (IOException e)
        {
            throw new WebException(StatusCode.UNKNOWN_ERROR, e);
        }

    }

    private static HttpURLConnection getHttpConnection(String url)
    {
        HttpURLConnection conn;
        try
        {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Client-ID " + CLIENT_ID);
            conn.setReadTimeout(100000);
            conn.connect();
            return conn;
        }
        catch (UnknownHostException e)
        {
            throw new WebException(StatusCode.UNKNOWN_HOST, e);
        }
        catch (IOException e)
        {
            throw new WebException(StatusCode.UNKNOWN_ERROR, e);
        }
    }

    private static void writeToConnection(HttpURLConnection conn, String message)
    {
        OutputStreamWriter writer;
        try
        {
            writer = new OutputStreamWriter(conn.getOutputStream());
            writer.write(message);
            writer.flush();
            writer.close();
        }
        catch (IOException e)
        {
            throw new WebException(StatusCode.UNKNOWN_ERROR, e);
        }
    }

    private static String getResponse(HttpURLConnection conn)
    {
        StringBuilder str = new StringBuilder();
        BufferedReader reader;
        try
        {
            if (conn.getResponseCode() != StatusCode.SUCCESS.getHttpCode())
            {
                throw new WebException(conn.getResponseCode());
            }
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null)
            {
                str.append(line);
            }
            reader.close();
        }
        catch (IOException e)
        {
            throw new WebException(StatusCode.UNKNOWN_ERROR, e);
        }
        if (str.toString().equals(""))
        {
            throw new WebException(StatusCode.UNKNOWN_ERROR);
        }
        return str.toString();
    }

}
