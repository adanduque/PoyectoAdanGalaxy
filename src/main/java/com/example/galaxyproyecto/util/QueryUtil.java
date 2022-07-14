package com.example.galaxyproyecto.util;

import java.util.Objects;

public class QueryUtil {
	public static String getLike(String str) {
		if (Objects.isNull(str)) {
			str = "";
		}
		return "%" + str + "%";
	}
}
