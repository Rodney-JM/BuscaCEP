package principall;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ApiSearch searchCep = new ApiSearch();
        searchCep.searchCep();
    }
}
