## JaCoCo Coverage

### Overall Coverage
![JaCoCo Overview](docs/jacoco-coverage.png)

### Core Classes Coverage
![JaCoCo Core Classes](docs/jacoco-core.png)

## Manual Mutation Testing

| # | Lỗi chèn | Test phát hiện | Đã hoàn tác |
|---|---|---|---|
| M1 | `>= MAX_FAILED_ATTEMPTS` → `>` | `login_WrongPassword5thTime_LocksAccount` | ✅ |
| M2 | Bỏ `if (account.isLocked())` | `login_WhileLocked_RejectsWithoutIncrement` | ✅ |
| M3 | `{4,19}` → `{4,20}` | `isValidUsername_BoundaryLength` | ✅ |

### Mutation Example
![Mutation Testing Example](docs/mutation-example.png)