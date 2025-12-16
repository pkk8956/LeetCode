package String_Search;

public class Run {

    /*
==========================================================================================================================================================================================================================================================
| Алгоритм        | Подходит для                    | Направление          | Предобработка                    | Время (среднее)  | Время (худший)   | Память                           | Особенности                                                     |
|-----------------|---------------------------------|----------------------|----------------------------------|------------------|------------------|----------------------------------|-----------------------------------------------------------------|
| Naive           | Любые                           | слева → направо      | нет                              | O(n·m)           | O(n·m)           | O(1)                             | Простейший, легко понять и реализовать                          |
| KMP             | Один needle                     | слева → направо      | LPS (префикс-функция)            | O(n + m)         | O(n + m)         | O(m)                             | Не откатывается назад по haystack                               |
| Rabin–Karp      | Один или несколько needle       | слева → направо      | хэш needle                       | O(n + m)         | O(n·m)           | O(1)                             | Rolling hash, проверка символов только при совпадении хэшей     |
| Boyer–Moore     | Один needle, длинные haystack   | справа → налево      | bad character, good suffix       | ≈O(n/m)          | O(n·m)           | O(|алфавит| + m)                 | Часто лучший на практике, большие прыжки по haystack            |
| Aho–Corasick    | Много needle                    | слева → направо      | Trie + failure links             | O(n + m + z)     | O(n + m + z)     | O(z × |алфавит|)                 | Находит все needle за один проход, идеально для словарей        |
| Suffix Array    | Один haystack, много поисков    | через бинарный поиск | построение массива суффиксов     | O(m log n)       | O(m log n)       | O(n)                             | Позволяет искать несколько needle быстро, требует предобработки |
| Suffix Tree     | Один haystack, много поисков    | по дереву            | построение дерева                | O(m)             | O(m)             | O(n)                             | Быстрый поиск за O(m), дорого строить, много памяти             |
==========================================================================================================================================================================================================================================================
    */


    public static void main(String[] args) {
        String haystack = "Some books are to be tasted, others to be swallowed, and some few to be chewed and digested.";
        String needle = "and";
        String anotherNeedle = "be";

        //Naive Search
        System.out.println("Naive Search. Indices: " + NaiveSearch.search(haystack, needle));

        //KMP Search
        System.out.println("KMP Search. Indices: " + KMPSearch.search(haystack, needle));

        //Rabin-Karp Search
        System.out.println("Rabin-Karp Search. Indices: " + RabinKarpSearch.search(haystack, needle));

        //Aho-Corasick Search
        AhoCorasick ac = new AhoCorasick();
        ac.addNeedle(needle);
        ac.addNeedle(anotherNeedle);
        ac.build();
        System.out.println("Aho-Corasick Search. Indices and Needles: " + ac.search(haystack));

        //Boyer-Moore Search
        System.out.println("Boyer-Moore Search. Indices: " + BoyerMooreSearch.search(haystack, needle));

        //Suffix Array Search
        SuffixArray sa = new SuffixArray(haystack);
        System.out.println("Suffix Array Search. Indices: " + sa.search(needle));


    }
    
}
