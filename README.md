# AndroidLib
Android常用代码库

添加依赖
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}

dependencies {
	implementation 'com.github.melodylzl:AndroidLib:1.0.2'
}


在Application中初始化
AndroidLib.init(this);
