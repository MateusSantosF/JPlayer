/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Comparators;

import java.util.Comparator;

import model.interfaces.IPlaylist;

/**
 *
 * @author Mateus Santos
 */
public class PlaylistComparatorByDate implements Comparator<IPlaylist>{

    @Override
    public int compare(IPlaylist o1, IPlaylist o2) {
        return o1.getCreateData().compareTo(o2.getCreateData());
    }
}
