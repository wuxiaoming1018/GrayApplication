package com.example.grayapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import com.example.grayapplication.view.GrayFrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {

        try{
            if ("FrameLayout".equals(name)) {
                int count = attrs.getAttributeCount();
                for (int i = 0; i < count; i++) {
                    String attributeName = attrs.getAttributeName(i);
                    String attributeValue = attrs.getAttributeValue(i);
                    if (attributeName.equals("id")) {
                        int id = Integer.parseInt(attributeValue.substring(1));
                        String resourceName = getResources().getResourceName(id);
                        if ("android:id/content".equals(resourceName)) {
                            GrayFrameLayout grayFrameLayout = new GrayFrameLayout(context, attrs);
                            return grayFrameLayout;
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return super.onCreateView(name, context, attrs);
    }
}
