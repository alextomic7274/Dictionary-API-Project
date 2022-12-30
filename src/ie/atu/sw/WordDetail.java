package ie.atu.sw;

import com.sun.source.tree.Tree;

import java.util.*;

public class WordDetail {
    private String definition;
    private Collection<Integer> pages;
    private StringBuffer sb;

    public WordDetail(WordDetail wordDetail) {
        this.definition = wordDetail.definition;
        this.pages = wordDetail.pages;
    }

    public WordDetail(int page, String definition) {
        pages = new TreeSet<>();
        this.pages.add(page);
        this.definition = definition;
    }

    // Use string buffer here (Thread safe)
    public void add(int page){
        this.pages.add(page);
    }

    public String toString() {
        sb = new StringBuffer();
        sb.append(this.definition+"\r\n"+"Pages: "+this.pages);
        return sb.toString();
    }
}
