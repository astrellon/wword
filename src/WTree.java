import java.util.ArrayList;
import java.util.Collections;

public class WTree
{
    public WTreeNode root = new WTreeNode();

    public void match(WWordContext context)
    {
        ArrayList<WTreeNode.ScoredTreeNode> searchList = new ArrayList<>();
        int maxScore = root.search(context, null, searchList);
        int totalScore = maxScore;
        cullBelowThreshold(searchList, maxScore);
        context.index++;

        while (!searchList.isEmpty() && context.hasValues()) {
            ArrayList<WTreeNode.ScoredTreeNode> newList = new ArrayList<>();

            maxScore = 0;
            for (WTreeNode.ScoredTreeNode node : searchList) {
                int score = node.node.search(context, node, newList);
                maxScore = maxScore > score ? maxScore : score;
            }
            totalScore += maxScore;
            context.index++;

            searchList = newList;
            cullBelowThreshold(searchList, totalScore);
        }

        Collections.sort(context.matches);
    }

    private static void cullBelowThreshold(ArrayList<WTreeNode.ScoredTreeNode> list, int maxScore) {
        int threshold = maxScore / 2;

        list.removeIf(x -> x.totalScore < threshold);
    }

    public void addWord(WWord word)
    {
        root.addWord(word, 0);
    }
}

