package modelCreator;

import model.MModel;

import java.util.Optional;

public interface ModelCreator<T> {
    T create(Optional<String> input, MModel<?>... models);
}
