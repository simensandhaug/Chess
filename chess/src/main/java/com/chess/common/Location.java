package com.chess.common;

import java.util.Objects;

public class Location {
    private final File file;
    private final Integer rank;

    public Location(File file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }

    public File getFile() {
        return this.file;
    }

    public Integer getRank() {
        return this.rank;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Location)) {
            return false;
        }
        Location location = (Location) o;
        return Objects.equals(file, location.file) && Objects.equals(rank, location.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }

    @Override
    public String toString() {
        return "{" +
                " file='" + getFile() + "'" +
                ", rank='" + getRank() + "'" +
                "}";
    }

}
