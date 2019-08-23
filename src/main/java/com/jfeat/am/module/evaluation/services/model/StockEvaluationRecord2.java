package com.jfeat.am.module.evaluation.services.model;

import com.jfeat.am.module.evaluation.services.domain.model.record.StockEvaluationRecord;

/**
 * @author hero
 * @date 17:47
 */
public class StockEvaluationRecord2 extends StockEvaluationRecord {
    private String[] productNames;
    private int commentStar;

    public String[] getProductNames() {
        return productNames;
    }

    public void setProductNames(String[] productNames) {
        this.productNames = productNames;
    }

    public int getCommentStar() {
        return commentStar;
    }

    public void setCommentStar(int commentStar) {
        this.commentStar = commentStar;
    }
}
