class Article implements Comparable<Article> {
    private String title;
    private int size;

    public Article(String title, int size) {
        this.title = title;
        this.size = size;
    }

    public String getTitle() {
        return this.title;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public int compareTo(Article otherArticle) {
        // add your code here!
        int res = Integer.compare(getSize(), otherArticle.getSize());

        return res == 0 ? getTitle().compareTo(otherArticle.getTitle()) : res;
    }
}