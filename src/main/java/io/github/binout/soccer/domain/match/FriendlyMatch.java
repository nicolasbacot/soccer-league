package io.github.binout.soccer.domain.match;

import io.github.binout.soccer.domain.date.FriendlyMatchDate;
import io.github.binout.soccer.domain.Player;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class FriendlyMatch implements Match {

    private final FriendlyMatchDate friendlyDate;
    private final Set<Player> players;

    FriendlyMatch(FriendlyMatchDate date, Set<Player> players) {
        this.friendlyDate = Objects.requireNonNull(date);
        this.players = checkPlayers(date, players);
    }

    @Override
    public LocalDate date() {
        return friendlyDate.date();
    }

    @Override
    public Stream<Player> players() {
        return players.stream();
    }

    @Override
    public int maxPlayers() {
        return 10;
    }

    @Override
    public int minPlayers() {
        return 10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FriendlyMatch that = (FriendlyMatch) o;

        return friendlyDate.equals(that.friendlyDate);

    }

    @Override
    public int hashCode() {
        return friendlyDate.hashCode();
    }
}