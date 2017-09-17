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
    compile 'net.hikaruna:rolling:+'
}

```

## 使い方

### ライブラリを使わない例

```
import java.util.*;

ArrayList<Integer> a = new ArrayList<>();
a.add(1);
a.add(3);
a.add(222);
for(Integer i : a) {
    System.out.println(i * i);
}
```

### ライブラリを使う例

```
import net.hikaruna.rolling.*; // ← packageを変えるだけ

ArrayList<Integer> a = new ArrayList<>();
a.add(1);
a.add(3);
a.add(222);
a.each(new VoidFunc<Integer>(){
    @Override
    public void call(Integer i) {
        System.out.println(i * i);
    }
});
```

## License
MIT