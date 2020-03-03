package com.hh.gf.springboot.helper;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** String处理工具类
 * 
 * @author 王磊 */
public class StringHelper extends StringUtils {

	public static int lastIndexOfWithTimes(String str, String searchStr, int times){
		int index = -1;

		for (int i = 0; i < times; i++) {
			index = str.lastIndexOf(searchStr);
			str = str.substring(0, index);
		}

		return index;
	}

	public static String toString(Object object){
		return object == null ? "" : object.toString();
	}

	/**
	 * 解决反馈过来HTML问题编码问题
	 * @param content
	 * @return 编码后的内容
	 */
	public static String encodeHTML(String content){

		content = content.replaceAll("&", "&amp;");
		content = content.replaceAll("<", "&lt;");
		content = content.replaceAll(">", "&gt;");
		content = content.replaceAll("\t", "    ");
		content = content.replaceAll("'", "&#39;");
		content = content.replaceAll("\\\\", "&#92;");
		content = content.replaceAll("\"", "&quot;");

		return content;
	}


	/**
	 * 默认情况流程引擎传递过来的的instanceId带bpmn:前缀，提取后面的instanceId
	 *
	 * @param instanceId
	 * @return
	 */
	public static String extractInstanceId(String instanceId) {
		Matcher matcher = Pattern.compile("\\d+").matcher(instanceId);
		return (matcher.find()) ? matcher.group() : null;
	}

}
