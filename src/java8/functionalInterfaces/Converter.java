package java8.functionalInterfaces;

interface Converter<F, T> {
    T convert(F from);
}
