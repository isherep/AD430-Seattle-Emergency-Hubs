package com.cap.seattleemergencyhubs;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableTextViewAdapter extends BaseExpandableListAdapter {

    Context context;

    String[] faqs={
            "What is Seattle Community Emergency Hub?",
            "Who is managing and financing Emergency Hubs?",
            "Does the Hub have water and food?"
    };

    String[][] answer={
            {"A Seattle Community Emergency Hub is a pre-determined location where neighbors and community members are likely to gather to begin exchanging information and resources.\n\n" +
                    " SEH does not use outside assistance from City services. \n\n" +
                    "The hub mission is accomplished SOLELY through community volunteers. \n\n"
                    },


            {"The hub mission is accomplished SOLELY through community volunteers.\n" },


            {"Hubs DO NOT HAVE food and water,\n\n"+
            "Your hub will have emergency box that helps community to get organized. \n\nThis box contains chairs, gloves, necessary paperwork\n\n" +
                    "You need to have food and water saved for emergency in you house."
                    }
    };


    public ExpandableTextViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return faqs.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return answer[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return faqs[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return answer[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String questionFaq = (String)getGroup(groupPosition);
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.faq_title, null);

        }

        TextView questionFaq2=convertView.findViewById(R. id.faqTitleView);
        questionFaq2.setTypeface(null, Typeface.NORMAL);
        questionFaq2.setText(questionFaq);
        return convertView;
    }



    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final String answerFaq = (String) getChild(groupPosition, childPosition);
        if (convertView == null){
            LayoutInflater inflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.faq_answer, null);
        }
        TextView answerFaq2 = convertView.findViewById(R. id.descriptionFaqView);
        answerFaq2.setText(answerFaq);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
