package liobouchan.OpenNLP;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import opennlp.tools.sentdetect.SentenceDetector;
import opennlp.tools.sentdetect.SentenceDetectorFactory;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.sentdetect.SentenceSample;
import opennlp.tools.sentdetect.SentenceSampleStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.TrainingParameters;

public class App 
{

	private static String generateTrainText() {
		final String lineSeparator = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        for (String space : Arrays.asList(" ", "\t", "\n", "\r", "\f")) {
        	for (String end : Arrays.asList(".", "!", "?", "...", ":")) {
        		for (String trainSentence : Arrays.asList("Train sentence", "This is a demo sentence", "Demo sentence", "ARTICULO 32")) {
        			sb.append(trainSentence).append(end);
                    sb.append(lineSeparator);
                    sb.append(space).append(trainSentence).append(end);
                    sb.append(lineSeparator);
                    sb.append(space).append(trainSentence).append(end).append(space);
                    sb.append(lineSeparator);
                }
            }
        }
        return sb.toString();
    }
	
	private static SentenceModel train(final String trainText) throws IOException {
		try (ObjectStream<String> lineStream = new PlainTextByLineStream(
			() -> new ByteArrayInputStream(trainText.getBytes()), Charset.forName("UTF-8"));
            ObjectStream<SentenceSample> sampleStream = new SentenceSampleStream(lineStream)) {
            	SentenceDetectorFactory sdFactory = new SentenceDetectorFactory("es", true, null, null);
            	return SentenceDetectorME.train("es", sampleStream, sdFactory, TrainingParameters.defaultParams());
        	}
    }
	
	private static String getSampleText() {
		return "This is sample sentence. " +
	    "This is another sample sentence. " +
		"ARTICULO 32 : " +
	    "If this is one more sample sentence? " +
	    "Of course!";
	}
	
	private static void test(SentenceModel sentenceModel, String text) {
		SentenceDetector sentenceDetector = new SentenceDetectorME(sentenceModel);
        String[] sentences = sentenceDetector.sentDetect(getSampleText());
        System.out.println("Detected sentences (" + sentences.length + "):");
        for (String sentence : sentences) {
        	System.out.println(sentence);
        }
    }

    public static void main( String[] args ) throws IOException
    {
    	SentenceModel sentenceModel = train(generateTrainText());
        test(sentenceModel, getSampleText());;
    }
}
