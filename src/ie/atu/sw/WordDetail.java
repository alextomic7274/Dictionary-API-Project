package ie.atu.sw;

import java.util.*;

/**
 * <p>WordDetail is a class which is used to store data about a word, including the actual word name, definition and pages
 * it exists on, stored in a collection.
 *
 * It implements Comparable interface which makes WordDetail objects suitable for comparison when sorting.
 * </p>
 *
 * @author alex
 */
public class WordDetail implements Comparable<WordDetail>{
    private String word = null;
    private String definition = null;
    private Collection<Integer> pages = null;
    private StringBuffer sb = null;

    // This is a cloning constructor which takes a WordDetail obj and clones its state to a new WordDetail.
    // Running time: O(1)
    /**
     * <p>Cloning constructor which takes a WordDetail object and clones its state to the newly created WordDetail.</p>
     *
     * @param wordDetail is needed for the purpose of object cloning.
     */
    public WordDetail(WordDetail wordDetail) {
        this.word = wordDetail.getWord();
        this.definition = wordDetail.definition;
        this.pages = wordDetail.getPages();
    }

    // This is a constructor which creates a WordDetail and updates the state based on the parameters.
    // Running time: O(1)
    /**
     * <p>Constructor that is used to create a new WordDetail, it then updates the state in the object
     * to the variables entered as parameters.</p>
     *
     * @param word the word to which the object relates to
     * @param page the page which the word was found on
     * @param definition the definition corresponding to the word
     */
    public WordDetail(String word, int page, String definition) {
        pages = new ArrayList<>();
        this.word = word;
        this.definition = definition;
        this.pages.add(page);
    }

    /**
     *
     * @return the collection of pages
     */
    public Collection<Integer> getPages() {
        return pages;
    }

    /**
     * @param page which is added to the collection
     */
    public void addPage(int page){
        this.pages.add(page);
    }

    // Overrides toString() and returns a string containing the definition and pages.
    // Running time: O(n) as it depends on size of unique pages, it could iterate n times to copy it to a new Set.
    /**
     * <p>Overrides toString() for WordDetail, and returns a string containing all important data about this object</p>
     *
     * @return a string containing definition and a collection of individual poges, the word is found on.
     */
    public String toString() {
        Set<Integer> uniquePages = new TreeSet<>(pages);
        sb = new StringBuffer();
        sb.append(this.word+", Definition(s): "+this.definition+"\r\n"+"Found on page(s): "+uniquePages);
        return sb.toString();
    }

    /**
     * @return the word corresponding to this object
     */
    public String getWord () { return word; }

    // Implements compareTo() and makes object eligible for sorting.
    // Running time: O(1) as an ArrayList knows its last index, thus it can determine the size instantly.
    /**
     *
     * @return size of collection storing pages
     */
    public int getPageTotal() {
        return pages.size();
    }

    // Allows the object to be compared.
    // Running time: O(1) as an ArrayList knows its last index, thus it can determine the size instantly.
    /**
     * Implements compareTo() and makes the object elible for comparison when sorting.
     * It uses the size of the pages collection to compare to another WordDetails pages.size().
     *
     * @param wordDetail2 the object to be compared.
     * @return 1 if greater, 0 if same, -1 if less.
     */
    public int compareTo(WordDetail wordDetail2) {
        if (this.pages.size() > wordDetail2.getPageTotal()) {
            return 1;
        }   else if (this.pages.size() == wordDetail2.getPageTotal()) {
            return 0;
        }   else return -1;
    }
}
