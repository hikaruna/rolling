# rolling
## 概要
rollingはjava7でmapReduceを行うためのライブラリです。

## Code Status
[![Build Status](https://travis-ci.org/hikaruna/rolling.svg?branch=master)](https://travis-ci.org/hikaruna/rolling)

## インストール

```
// build.gradle

repositories {
    jcenter()
}

dependencies {
    compile 'net.hikaruna:rolling:0.0.2'
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

ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 4, 8));
int mapReduceResult = arrayList.map(new Function<Integer, Integer>() {
    @Override
    public Integer call(Integer item) {
        return item * item;
    }
}).reduce(0, new Function2<Integer, Integer, Integer>() {
    @Override
    public Integer call(Integer result, Integer item) {
        return result + item;
    }
});

assertEquals(81, mapReduceResult);
```

## License
MIT