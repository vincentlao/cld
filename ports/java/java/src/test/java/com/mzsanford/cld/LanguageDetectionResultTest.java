package com.mzsanford.cld;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

public class LanguageDetectionResultTest {
    private LanguageDetectionResult result = null;
    private Locale locale = new Locale("en");

    @Test
    public void testGetProbableLocale() {
        result = new LanguageDetectionResult(locale, false, null);
        assertEquals(locale, result.getProbableLocale());
    }

    @Test
    public void testIsReliable() {
        result = new LanguageDetectionResult(locale, true, null);
        assertEquals(true, result.isReliable());
        
        result = new LanguageDetectionResult(locale, false, null);
        assertEquals(false, result.isReliable());
    }

    @Test
    public void testGetCandidates() {
        List<LanguageDetectionCandidate> candidates = new LinkedList<LanguageDetectionCandidate>();
        result = new LanguageDetectionResult(locale, true, candidates);
        assertArrayEquals(candidates.toArray(), result.getCandidates().toArray());
    }

    @Test
    public void testToString() {
        result = new LanguageDetectionResult(locale, true, null);
        assertTrue(result.toString().indexOf("probableLocale=en") > 0);
        assertTrue(result.toString().indexOf("reliable=true") > 0);
    }

}
