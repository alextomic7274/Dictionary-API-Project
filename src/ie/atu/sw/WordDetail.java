package ie.atu.sw;

import java.util.*;

public class WordDetail implements Comparable<WordDetail>{
    private String word = null;
    private String definition = null;
    private Collection<Integer> pages = null;
    private StringBuffer sb = null;

    public WordDetail(WordDetail wordDetail) {
        this.word = wordDetail.getWord();
        this.definition = wordDetail.definition;
        this.pages = wordDetail.pages;
    }

    public WordDetail(String word, int page, String definition) {
        pages = new ArrayList<>();
        this.word = word;
        this.pages.add(page);
        this.definition = definition;
    }

    // Use string buffer here (Thread safe)
    public void add(int page){
        this.pages.add(page);
    }

    public String toString() {
        Set<Integer> uniquePages = new TreeSet<>(pages);
        sb = new StringBuffer();
        sb.append(this.word+", Definition(s): "+this.definition+"\r\n"+"Found on page(s): "+uniquePages);
        return sb.toString();
    }

    public String getWord () { return word; }

    public int getPageTotal() {
        return pages.size();
    }

    @Override
    public int compareTo(WordDetail wordDetail2) {
        if (this.pages.size() > wordDetail2.getPageTotal()) {
            return 1;
        }   else if (this.pages.size() == wordDetail2.getPageTotal()) {
            return 0;
        }   else return -1;
    }
}
