package com.project.hackers.hackattack.Service;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.parse.*;
import com.project.hackers.hackattack.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by athatscomp on 1/31/15.
 */
public class ImageService
{
    private static ImageService serviceInstance;
    private static final Object lock = new Object();
    private ImageService(){

    }

    public static ImageService getServiceInstance()
    {
        if(serviceInstance == null)
        {
            synchronized (lock)
            {
                if (serviceInstance == null)
                {
                    serviceInstance = new ImageService();
                }
            }
        }
        return serviceInstance;
    }

    public Bitmap getImage(String url)
    {
        return null;//BitmapFactory.decodeResource(Application.getResources(), R.drawable.camera);
    }

    public void postImage(File image){
        FileInputStream in;
        ParseFile pf;
        byte[] arr;

        try {
            in = new FileInputStream(image);
            arr = new byte[in.available()];
            in.read(arr);
        }
        catch (FileNotFoundException e) {
            System.err.println("Image not found");
            return;
        }
        catch (IOException io) {
            System.err.println("Input Stream Unavailable");
            return;
        }

        pf = new ParseFile(image.getName(), arr);
        pf.saveInBackground();
    }
}
