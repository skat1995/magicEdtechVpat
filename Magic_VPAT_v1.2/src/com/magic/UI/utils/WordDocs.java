package com.magic.UI.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.magic.UI.pages.VPAT;

public class WordDocs {
	private static final Map<Integer, List<String>> dynamicHashMap = new HashMap<>();

	// Update content in a specific paragraph
	private static void updateHashMap(int paragraphIndex, int wordIndex, String replace) {
		List<String> para = dynamicHashMap.get(paragraphIndex);
		if (para != null && wordIndex < para.size()) {
			para.set(wordIndex, replace);
			dynamicHashMap.put(paragraphIndex, para);
		}
	}

	// Append content to a specific paragraph
	private static void appendHashMap(int paragraphIndex, String toAppend) {
		List<String> para = dynamicHashMap.get(paragraphIndex);
		if (para != null) {
			para.add(toAppend);
			dynamicHashMap.put(paragraphIndex, para);
		}
	}

	private static void saveHashMapToDocument(Map<Integer, List<String>> hashMap, XWPFDocument document) {
		for (Map.Entry<Integer, List<String>> entry : hashMap.entrySet()) {
			int paragraphIndex = entry.getKey();
			List<String> words = entry.getValue();

			XWPFParagraph paragraph = document.getParagraphs().get(paragraphIndex);

			for (int i = paragraph.getRuns().size() - 1; i >= 0; i--) {
				paragraph.removeRun(i);
			}

			XWPFRun newRun = paragraph.createRun();
			newRun.setText(getPara(words));

		}
	}

	/**
	 * <ul>
	 * <b>A method takes a paragraph of text, splits it into individual words, and
	 * returns a list containing those words: </b>It can be useful when you need to
	 * process or analyze text on a word-by-word basis semantic role
	 * </ul>
	 * 
	 * @throws IOException
	 * 
	 */
	private static List<String> getWordsFromPara(String text) {
		List<String> allWords = new ArrayList<>();

		String[] words = text.split("\\s+"); // Split on whitespace

		// Collect words along with special characters
		for (String word : words) {
			allWords.add(word);

		}
//	      System.out.println(allWords);
		return allWords;
	}

	private static String getPara(List<String> words) {
		StringBuilder result = new StringBuilder();

		for (String word : words) {
			result.append(word).append(" ");
		}

		// Remove the trailing whitespace
		return result.toString().trim();
	}

	private static int[] paraIndexWordIndex(Map<Integer, List<String>> dynamicHashMap, String searchText) {
		for (Map.Entry<Integer, List<String>> entry : dynamicHashMap.entrySet()) {
			int paragraphIndex = entry.getKey();
			List<String> words = entry.getValue();

			if (words.contains(searchText)) {
				int wordIndex = words.indexOf(searchText);
				return new int[] { paragraphIndex, wordIndex };
			}
		}
		return new int[] { -1, -1 };
	}

	private static void updateAllOccurrences(String searchText, String replace) {
		for (Map.Entry<Integer, List<String>> entry : dynamicHashMap.entrySet()) {
			List<String> para = entry.getValue();
			if (para.contains(searchText)) {
				int wordIndex = para.indexOf(searchText);
				para.set(wordIndex, replace);
			}
		}
	}

	public static void readDoc(String docPathWithName,String docNameForWrite) throws IOException {
		FileInputStream fis = new FileInputStream(docPathWithName);
		XWPFDocument document = new XWPFDocument(fis);
		int[] paraWordIndex;
		String[] searchTextArray = { "[Company]", "Product/Version:", "Date:", "Description:", "Information:",
				"Used:" };
		List<XWPFParagraph> paragraphs = document.getParagraphs();
		for (int i = 0; i < paragraphs.size(); i++) {
			XWPFParagraph paragraph = paragraphs.get(i);
			dynamicHashMap.put(i, getWordsFromPara(paragraph.getText()));
			// System.out.println("para " + i + " " + getAlcrs(paragraph.getText()));
		}
		for (int j = 0; j < searchTextArray.length; j++) {
			paraWordIndex = paraIndexWordIndex(dynamicHashMap, searchTextArray[j]);
			int paraIndex = paraWordIndex[0];
			int wordIndex = paraWordIndex[1];
			if ("[Company]".equals(searchTextArray[j])) {
				updateAllOccurrences(searchTextArray[j], VPAT.details.getStrPreapredByTxt());
			} else if ("Product/Version:".equals(searchTextArray[j])) {
				appendHashMap(paraIndex, VPAT.details.getStrNameOfProduct());
			} else if ("Date:".equals(searchTextArray[j])) {
				appendHashMap(paraIndex, VPAT.details.getStrReportData());
			} else if ("Description:".equals(searchTextArray[j])) {
				appendHashMap(paraIndex, VPAT.details.getStrPrdDescription());
			} else if ("Information:".equals(searchTextArray[j])) {
				appendHashMap(paraIndex, VPAT.details.getStrContactInformation());
			}
			saveHashMapToDocument(dynamicHashMap, document);

			FileOutputStream fos = new FileOutputStream(
					System.getProperty("user.dir") + "/vpat/doc/" + docNameForWrite + ".docx");
			document.write(fos);
			System.out.println("Word document updated successfully!");
			fis.close();
			fos.close();
		}
	}

	
	
}
