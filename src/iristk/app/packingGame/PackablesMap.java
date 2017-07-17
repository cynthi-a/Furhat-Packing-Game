package iristk.app.packingGame;

import iristk.app.quiz.Question;
import iristk.app.quiz.QuestionSet;
import iristk.system.IrisUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javafx.util.Pair;

import org.slf4j.Logger;


public class PackablesMap extends HashMap<String, String>{
	
	private static Logger logger = IrisUtils.getLogger(QuestionSet.class);
	private Random generator;
	
	public PackablesMap(InputStream questionFile) throws IOException {
		generator = new Random();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(questionFile));
			String line = br.readLine();
			
			int packablesNo = 0;
			int ln = 0;
			while ((line = br.readLine()) != null) {
				ln++;
				if (!line.matches("[A-Za-z0-9,\\.;\\?'\\- ]*")) {
					System.err.println("Illegal line " + ln + ": " + line);
					continue;
				}
//				String[] cols = line.split(";");
//				if (cols.length < 5) {
//					logger.warn("Not enough columns in line " + ln + ": " + line);
//					continue;
//				} 
//				Question q = new Question("q" + qn++, cols);
//				add(q);
				
				String[] cols = line.split(";");
				
				if (cols.length >= 2) {
					this.put(cols[0], cols[1]);
				} else {
					this.put(cols[0], null);
				}
				packablesNo++;
			}
			logger.info(packablesNo + " packable items read");
//			randimize();
			System.out.println(this.toString());
		} catch (IOException e) {
			throw new IOException("Problem reading questions: " + e.getMessage());
		}
	}
	
	public PackablesMap(File file) throws IOException  {
		this(new FileInputStream(file));
	}
	
	public Pair<String,String> getRandom() {
		List<String> keys = new ArrayList<String>(this.keySet());
		String randomKey = keys.get(generator.nextInt(keys.size()));
		String value     = this.get(randomKey);
		
		Pair<String,String> toReturn = new Pair<>(randomKey, value);
		
		return toReturn;
	}
	
}
