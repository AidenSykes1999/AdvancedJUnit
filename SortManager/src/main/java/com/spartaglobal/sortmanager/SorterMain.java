package com.spartaglobal.sortmanager;

import com.spartaglobal.sortmanager.controller.SortController;
import com.spartaglobal.sortmanager.viewer.SortView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class SorterMain {
    private static Logger logger = LogManager.getLogger("Sort Logger");
    public static void main(String[] args) {

        logger.error("Looking for User Input");
        SortView view = new SortView();
        String sortChoice = view.sortSelector();
        logger.error("Attempting to perform a merge.");
        SortController controller = new SortController();
        String result = controller.initiateSort(sortChoice);


        view.displaySort(result);
    }
}