package com.example.tarkvara.allahindluz;

import android.os.AsyncTask;

class GetDataJSON extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
        /**
        URL url = null;
        try {
            url = new URL("http://ip");
            HttpURLConnection urlconn = (HttpURLConnection) url.openConnection();
            urlconn.setRequestMethod("POST");
            urlconn.setRequestProperty("key", "value");
            urlconn.setDoOutput(true);
            urlconn.setDoInput(true);

            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("word", paramValue1)

            String query = builder.build().getEncodedQuery();
            OutputStream os = urlconn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            os.close();

            urlconn.connect();


        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
**/
            return "";
    }
}