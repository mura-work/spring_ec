package com.example.demo.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.thymeleaf.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataTransformationUtil {
	/**
	 * 引数のオブジェクトをJSON文字列に変換する
	 * @param data オブジェクトのデータ
	 * @return 変換後JSON文字列
	 */
	public static String getJsonData(Object data) {
		String retVal = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			retVal = objectMapper.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			System.err.println(e);
		}
		return retVal;
	}

	/**
	 * 引数の文字列をエンコードする
	 * @param data 任意の文字列
	 * @return エンコード後の文字列
	 */
	public static String encode(String data) {
		if (StringUtils.isEmpty(data)) {
			return data;
		}
		String retVal = null;
		try {
			retVal = URLEncoder.encode(data, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.err.println(e);
		}
		return retVal;
	}

	/**
	 * 引数の文字列をデコードする
	 * @param data 任意の文字列
	 * @return エンコード後の文字列
	 */
	public static String decode(String data) {
		if (StringUtils.isEmpty(data)) {
			return data;
		}
		String retVal = null;
		try {
			retVal = URLDecoder.decode(data, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.err.println(e);
		}
		return retVal;
	}
}
