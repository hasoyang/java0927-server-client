package audioplay;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.FileInputStream;
import java.net.URL;

import javazoom.jl.player.Player;

public class WavMain {

	public static void main(String[] args) {
		try
		{
		/*	URL url = new URL("file:////Users/jihyunsub/Downloads/resource-master/pottery_workshop.wav" );
			AudioClip audio = Applet.newAudioClip(url);
			audio.play();
			*/
			Player player = new Player(new FileInputStream("/Users/jihyunsub/Downloads/resource-master/Twinkle.mp3"));
			player.play();
			//mp3 재생은 javafx 패키지의 MediaPlayer 클래스로도 가능
			/*
			javafx.scene.media m = new javafx.scene.media("파일경로");
			MediaPlayer p = new MediaPlayer(m);
			p.play();
			*/
		}
		catch(Exception e)
		{
			System.out.printf("%s\n", e.getMessage());
		}

	}

}
