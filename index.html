# rolling
## 概要
rollingはjava7でmapReduceを行うためのライブラリです。

## Status
[![Build Status](https://travis-ci.org/hikaruna/rolling.svg?branch=master)](https://travis-ci.org/hikaruna/rolling)
[![Download](https://api.bintray.com/packages/hikaruna/maven/rolling/images/download.svg) ](https://bintray.com/hikaruna/maven/rolling/_latestVersion)


## インストール

```
// build.gradle

repositories {
    jcenter()
}

dependencies {
    compile 'net.hikaruna:rolling:1.2.0'
}

```

## 使い方

### ライブラリを使わない例

```
final ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 4, 8));

final ArrayList<Integer> squaredList = new ArrayList<>();
for(Integer i : arrayList) {
    squaredList.add(i * i);
}

int sum = 0;
for(Integer i : squaredList) {
    sum += i;
}

assertEquals(81, sum);
```

### ライブラリを使う例

```
import net.hikaruna.rolling.*;
import net.hikaruna.rolling.function.*;

final ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 4, 8));

final int mapReduceResult = arrayList.map(new Function<Integer, Integer>() {
    @Override
    public Integer apply(final Integer item) {
        return item * item;
    }
}).reduce(0, new BiFunction<Integer, Integer, Integer>() {
    @Override
    public Integer apply(final Integer result, final Integer item) {
        return result + item;
    }
});

assertEquals(81, mapReduceResult);
```

## License
MIT
