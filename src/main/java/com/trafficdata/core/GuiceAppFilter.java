package com.trafficdata.core;

import com.google.inject.servlet.GuiceFilter;

import javax.servlet.annotation.WebFilter;

/**
 * Created by minhmo on 12/14/16.
 */
@WebFilter(urlPatterns = "/*")
public class GuiceAppFilter extends GuiceFilter {
}
