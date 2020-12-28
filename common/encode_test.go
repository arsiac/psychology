package common

import (
	"golang.org/x/crypto/bcrypt"
	"testing"
)

func TestEncodeAndCompare(t *testing.T) {
	password := "kbJHVSBKBsbdjhSJDJXSJH"
	encode := EncryptPassword(password)

	result := ComparePassword(password, encode)
	if !result {
		t.Error("not equal")
	}
}

// 随机生成 1000 个 cost 检查是否在规定范围之内
func TestGetRandomCost(t *testing.T) {
	for i := 1; i < 1000; i++ {
		cost := GetRandomCost()
		if cost > bcrypt.MaxCost || cost < bcrypt.MinCost {
			t.Error(cost, bcrypt.MinCost, bcrypt.MaxCost)
		}
	}
}
