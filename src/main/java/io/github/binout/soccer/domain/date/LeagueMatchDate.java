package io.github.binout.soccer.domain.date;

import io.github.binout.soccer.domain.player.Player;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LeagueMatchDate implements MatchDate {

    private final LocalDate date;
    private final Set<Player> presents;

    LeagueMatchDate(LocalDate date) {
        this.date = Objects.requireNonNull(date);
        this.presents = new HashSet<>();
    }

    @Override
    public LocalDate date() {
        return date;
    }

    @Override
    public void present(Player player) {
        presents.add(player);
    }

    @Override
    public int nbPresents() {
        return presents.size();
    }

    @Override
    public void absent(Player player) {
        presents.remove(player);
    }

    @Override
    public boolean isAbsent(Player player) {
        return !presents.contains(player);
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
