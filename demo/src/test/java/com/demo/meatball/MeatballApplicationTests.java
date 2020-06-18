package com.demo.meatball;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;
import org.json.JSONObject;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.*;
import java.util.HashMap;

@SpringBootTest
class MeatballApplicationTests {
    /*public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        //map.put(SpeechConstant.APP_ID, appid);
        //map.put(SpeechConstant.APP_KEY,appKey);
        //map.put(SpeechConstant.SECRET,secret);
        AipSpeech client = new AipSpeech("20475993", "7zj7zSGamuG4tML2yWYB2Y21", "bn8XMOLa3CULjyrDpCVUEeaX8rkDpNiY");
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        JSONObject res = client.asr("C:\\Users\\徐Sir\\Documents\\录音\\录音.m4a", "wav", 16000, null);
        System.out.println(res);
    }*/
    @Test
    void contextLoads() {
    }


    //private static org.slf4j.Logger log = LoggerFactory.getLogger();

    private static final String testFileName = "C:\\Users\\徐Sir\\Documents\\录音\\录音2.pcm"; // 百度语音提供技术支持
    private static final String mp3FileName = "C:\\Users\\徐Sir\\Documents\\录音\\录音.mp3"; // 百度语音提供技术支持
    //put your own params here
    // 下面3个值要填写自己申请的app对应的值
    private static final String API_KEY = "7zj7zSGamuG4tML2yWYB2Y21";
    private static final String SECRET_KEY = "bn8XMOLa3CULjyrDpCVUEeaX8rkDpNiY";
    private static final String APP_ID = "20475993";
    private static AipSpeech client;

    public static void main(String[] args) throws Exception {
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
        convertMP32Pcm(mp3FileName, testFileName);
        JSONObject asrRes = client.asr(testFileName, "pcm", 16000, null);
        System.out.println(asrRes);
    }

    /**
     * 单例 懒加载模式 返回实例
     * @return
     */
    public static AipSpeech getInstance(){
        if (client==null){
            synchronized (AipSpeech.class){
                if (client==null) {
                    client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
                }
            }
        }
        return client;
    }

    /**
     * 语音合成
     * @param word 文字内容
     * @param outputPath 合成语音生成路径
     * @return
     */
    public static boolean SpeechSynthesizer(String word, String outputPath) {
        /*
        最长的长度
         */
        int maxLength = 1024;
        if (word.getBytes().length >= maxLength) {
            return false;
        }
        // 初始化一个AipSpeech
        client = getInstance();

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 调用接口
        TtsResponse res = client.synthesis(word, "zh", 1, null);
        byte[] data = res.getData();
        org.json.JSONObject res1 = res.getResult();
        if (data != null) {
            try {
                Util.writeBytesToFileSystem(data, outputPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        if (res1 != null) {
            System.out.println("============="+res1.toString());
            //log.info(" result : " + res1.toString());
        }
        return false;

    }

    /**
     * 语音识别
     * @param videoPath
     * @param videoType
     * @return
     */
    public static String SpeechRecognition(String videoPath, String videoType) {
        // 初始化一个AipSpeech
        client = getInstance();

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理


        // 调用接口
        JSONObject res = client.asr(videoPath, videoType, 16000, null);
        System.out.println("============="+ res.toString());
        //log.info(" SpeechRecognition : " + res.toString());
        return res.toString();
    }


    /**
     *  mp3转pcm
     * @param mp3filepath MP3文件存放路径
     * @param pcmfilepath pcm文件保存路径
     * @return
     */
    /*public static boolean convertMP32Pcm(String mp3filepath, String pcmfilepath){
        try {
            //获取文件的音频流，pcm的格式
            AudioInputStream audioInputStream = getPcmAudioInputStream(mp3filepath);
            //将音频转化为  pcm的格式保存下来
            AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, new File(pcmfilepath));
            return true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }*/
    public static void convertMP32Pcm(String mp3filepath,String pcmfilepath) throws Exception{
        File mp3 = new File(mp3filepath);
        File pcm = new File(pcmfilepath);
        //原MP3文件转AudioInputStream
        //AudioInputStream mp3audioStream = AudioSystem.getAudioInputStream(mp3);
        FileInputStream mp3Stream = new FileInputStream(mp3);
        InputStream bufferedIn = new BufferedInputStream(mp3Stream);
        AudioInputStream mp3audioStream = AudioSystem.getAudioInputStream(bufferedIn);
        //将AudioInputStream MP3文件 转换为PCM AudioInputStream
        //AudioInputStream pcmaudioStream = AudioSystem.getAudioInputStream(AudioFormat.Encoding.PCM_SIGNED, mp3audioStream);
        AudioFormat baseFormat = mp3audioStream.getFormat();
        AudioFormat targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16,
                baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);        //准备转换的流输出到OutputStream
        OutputStream os = new FileOutputStream(pcm);
        AudioInputStream pcmaudioStream = AudioSystem.getAudioInputStream(targetFormat,mp3audioStream);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        while ((bytesRead=pcmaudioStream.read(buffer, 0, 8192))!=-1) {
            os.write(buffer, 0, bytesRead);
        }
        os.close();
        pcmaudioStream.close();
    }

    /**
     * 获得pcm文件的音频流
     * @param mp3filepath
     * @return
     */
    private static AudioInputStream getPcmAudioInputStream(String mp3filepath) {
        File mp3 = new File(mp3filepath);
        AudioInputStream audioInputStream = null;
        AudioFormat targetFormat = null;
        try {
            AudioInputStream in = null;
            MpegAudioFileReader mp = new MpegAudioFileReader();
            in = mp.getAudioInputStream(mp3);
            AudioFormat baseFormat = in.getFormat();
            targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16,
                    baseFormat.getChannels(), baseFormat.getChannels()*2, baseFormat.getSampleRate(), false);
            audioInputStream = AudioSystem.getAudioInputStream(targetFormat, in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return audioInputStream;
    }

}
