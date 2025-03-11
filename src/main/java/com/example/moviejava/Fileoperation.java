package com.example.moviejava;

import ServerClient.Server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Fileoperation
{
    public void readfile()throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("movies.txt"));
        BufferedReader cr = new BufferedReader(new FileReader("thumbnail_Links.txt"));
        BufferedReader dr = new BufferedReader(new FileReader("trailers.txt"));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] out = line.split(",");
            String name = out[0];
            int year = Integer.parseInt(out[1]);
            String Genre1 = out[2];
            String Genre2 = out[3];
            String Genre3 = out[4];
            int duration = Integer.parseInt(out[5]);
            String Productioncompany = out[6];
            int budget = Integer.parseInt(out[7]);
            int revenue = Integer.parseInt(out[8]);

            String line1 = cr.readLine();
            if (line1 == null) break;
            String []out1=line1.split(" ");
            String thumbnaillink=out1[0];

            String line2 = dr.readLine();
            if (line2 == null) break;
            String []out2=line2.split(",");
            String youtubelink=out2[1];

            Cinemas c = new Cinemas(name, year, Genre1, Genre2, Genre3, duration, Productioncompany, budget, revenue,thumbnaillink,youtubelink);

            Server.movielist.add(c);

        }
        br.close();
        cr.close();
        dr.close();
    }
}
