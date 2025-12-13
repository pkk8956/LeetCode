package Advanced_Data_Structures;

import java.util.*;

public class ISAM {

    private static final int PAGE_SIZE = 4;

    private static class DataPage {
        List<Integer> keys = new ArrayList<>();
        DataPage overflow;
    }

    private static class IndexEntry {
        int key;
        DataPage page;

        IndexEntry(int key, DataPage page) {
            this.key = key;
            this.page = page;
        }
    }

    private final List<DataPage> dataPages = new ArrayList<>();
    private final List<IndexEntry> index = new ArrayList<>();

    public ISAM(List<Integer> sortedData) {
        buildDataPages(sortedData);
        buildIndex();
    }

    private void buildDataPages(List<Integer> data) {
        DataPage current = null;

        for (int key : data) {
            if (current == null || current.keys.size() == PAGE_SIZE) {
                current = new DataPage();
                dataPages.add(current);
            }
            current.keys.add(key);
        }
    }

    private void buildIndex() {
        for (DataPage page : dataPages) {
            index.add(new IndexEntry(page.keys.get(0), page));
        }
    }

    public boolean search(int key) {
        DataPage page = findPage(key);
        if (page == null) return false;

        while (page != null) {
            if (page.keys.contains(key)) return true;
            page = page.overflow;
        }
        return false;
    }

    public void insert(int key) {
        DataPage page = findPage(key);
        if (page == null) return;

        if (page.keys.size() < PAGE_SIZE) {
            insertSorted(page.keys, key);
        } else {
            DataPage overflow = page;
            while (overflow.overflow != null) {
                overflow = overflow.overflow;
            }
            overflow.overflow = new DataPage();
            overflow.overflow.keys.add(key);
        }
    }

    private DataPage findPage(int key) {
        IndexEntry result = null;

        for (IndexEntry entry : index) {
            if (entry.key <= key) result = entry;
            else break;
        }

        return result == null ? null : result.page;
    }

    private void insertSorted(List<Integer> list, int key) {
        int i = 0;
        while (i < list.size() && list.get(i) < key) i++;
        list.add(i, key);
    }

}
