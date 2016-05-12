package io.github.binout.soccer.domain.date;

import io.github.binout.soccer.domain.Player;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LeagueMatchDate implements MatchDate {

    private final LocalDate date;
    private final Set<Player> absents;

    LeagueMatchDate(LocalDate date) {
        this.date = Objects.requireNonNull(date);
        this.absents = new HashSet<>();
    }

    @Override
    public LocalDate date() {
        return date;
    }

    @Override
    public void present(Player player) {
        absents.remove(player);
    }

    @Override
    public void absent(Player player) {
        absents.add(player);
    }

    @Override
    public boolean isAbsent(Player player) {
        return absents.contains(player);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeagueMatchDate that = (LeagueMatchDate) o;

        return date.equals(that.date);

    }

    @Override
    public int hashCode() {
        return date.hashCode();
    }
}