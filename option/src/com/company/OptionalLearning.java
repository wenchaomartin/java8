package com.company;

import java.util.Optional;

/**
 * http://www.oracle.com/technetwork/articles/java/java8-optional-2175753.html
 * @author martin
 */
public class OptionalLearning {

    public static void main(String[] args) {
        USB usb = new USB("kingStone");
        Optional<USB> optional = Optional.ofNullable(usb);
        optional.ifPresent(System.out::println);
        optional.map(USB::getVersion).ifPresent(System.out::println);
    }

    public void emptyOptional (){
        //maybe empty optional
        SoundCard soundCard = null;
        Optional<SoundCard> sc = Optional.ofNullable(soundCard);

        SoundCard soundCard1 = new SoundCard();
        //must not empty
        Optional<SoundCard> soundCard2 = Optional.of(soundCard1);
        //empty optional
        Optional<SoundCard> soundCard3 = Optional.empty();
    }
}
