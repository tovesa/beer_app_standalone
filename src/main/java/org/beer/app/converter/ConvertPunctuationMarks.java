package org.beer.app.converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertPunctuationMarks {

	public static String formatPunctuationMarks(String line) {
		String formattedLine = line;
		formattedLine = addDotAfterDate(formattedLine);
		formattedLine = replaceCommaBeforeDate(formattedLine);
		formattedLine = addDotAfterScore(formattedLine);
		formattedLine = changeCommasToDots(formattedLine);
		formattedLine = replaceCommaBeforeScore(formattedLine);
		return formattedLine;
	}

	public static String changeCommasToDots(String line) {
		String formattedLine;
		// formattedLine = line.replaceAll("cl ", "cl. ");
		// formattedLine = formattedLine.replaceAll("cl,", "cl.");
		// formattedLine = formattedLine.replaceAll("ml ", "ml. ");
		// formattedLine = formattedLine.replaceAll("ml,", "ml.");
		formattedLine = line.replaceAll("Pirkkala,", "Pirkkala.");
		formattedLine = formattedLine.replaceAll("Ruovesi,", "Ruovesi.");
		formattedLine = formattedLine.replaceAll("Kasvot,", "Kasvot.");
		formattedLine = formattedLine.replaceAll("Konttori,", "Konttori.");
		formattedLine = formattedLine.replaceAll("Nordic,", "Nordic.");
		formattedLine = formattedLine.replaceAll("Apina,", "Apina.");
		formattedLine = formattedLine.replaceAll("Tuulensuu,", "Tuulensuu.");
		formattedLine = formattedLine.replaceAll("Kaleva,", "Kaleva.");
		formattedLine = formattedLine.replaceAll("Koivistonkylä,", "Koivistonkylä.");
		formattedLine = formattedLine.replaceAll("\\.,", ".");
		formattedLine = formattedLine.replaceAll(",\\.", ".");
		formattedLine = formattedLine.replaceAll("\\.\\.", ".");
		StringBuffer sb = new StringBuffer();
		sb.append(formattedLine);
		return sb.toString();
	}

	private static String addDotAfterDate(String line) {
		Pattern p = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
		Matcher m = p.matcher(line);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			String text = m.group();
			StringBuffer formattedDate = new StringBuffer();
			formattedDate.append(text);
			formattedDate.append(".");
			m.appendReplacement(sb, formattedDate.toString());
		}
		m.appendTail(sb);
		String ret = sb.toString().replaceFirst("\\s+$", "");
		return ret;
	}

	private static String replaceCommaBeforeDate(String line) {
		Pattern p = Pattern.compile(", \\d{4}-\\d{2}-\\d{2}");
		Matcher m = p.matcher(line);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			String text = m.group();
			String formattedText = text.replaceFirst(",", ".");
			m.appendReplacement(sb, formattedText);
		}
		m.appendTail(sb);
		String ret = sb.toString().replaceFirst("\\s+$", "");
		return ret;
	}

	private static String addDotAfterScore(String line) {
		Pattern p = Pattern.compile("\\d{6}");
		Matcher m = p.matcher(line);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			String text = m.group();
			StringBuffer formattedScore = new StringBuffer();
			formattedScore.append(text);
			formattedScore.append(".");
			m.appendReplacement(sb, formattedScore.toString());
		}
		m.appendTail(sb);
		String ret = sb.toString().replaceFirst("\\s+$", "");
		return ret;
	}

	private static String replaceCommaBeforeScore(String line) {
		Pattern p = Pattern.compile(", \\d{6}");
		Matcher m = p.matcher(line);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			String text = m.group();
			String formattedText = text.replaceFirst(",", ".");
			m.appendReplacement(sb, formattedText);
		}
		m.appendTail(sb);
		String ret = sb.toString().replaceFirst("\\s+$", "");
		return ret;
	}

	private static String addDotBetweenBbeAndScore(String line) {
		Pattern p = Pattern.compile("\\d{4}-\\d{2}-\\d{2}\\.\\s\\d{6}");
		Matcher m = p.matcher(line);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			String text = m.group();
			StringBuffer formattedDate = new StringBuffer();
			formattedDate.append(text);
			formattedDate.append(".");
			m.appendReplacement(sb, formattedDate.toString());
		}
		m.appendTail(sb);
		String ret = sb.toString().replaceFirst("\\s+$", "");
		return ret;
	}
}