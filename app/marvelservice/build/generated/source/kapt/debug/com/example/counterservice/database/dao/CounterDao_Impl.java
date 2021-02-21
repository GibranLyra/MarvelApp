package com.example.counterservice.database.dao;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.counterservice.model.Counter;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.Void;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CounterDao_Impl implements CounterDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Counter> __insertionAdapterOfCounter;

  private final EntityDeletionOrUpdateAdapter<Counter> __deletionAdapterOfCounter;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCount;

  public CounterDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCounter = new EntityInsertionAdapter<Counter>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `counters` (`count`,`id`,`title`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Counter value) {
        stmt.bindLong(1, value.getCount());
        if (value.getId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getId());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
      }
    };
    this.__deletionAdapterOfCounter = new EntityDeletionOrUpdateAdapter<Counter>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `counters` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Counter value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
    this.__preparedStmtOfUpdateCount = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE counters SET count=? WHERE id == ?";
        return _query;
      }
    };
  }

  @Override
  public Completable saveCounters(final List<Counter> counter) {
    return Completable.fromCallable(new Callable<Void>() {
      @Override
      public Void call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCounter.insert(counter);
          __db.setTransactionSuccessful();
          return null;
        } finally {
          __db.endTransaction();
        }
      }
    });
  }

  @Override
  public void delete(final Counter counter) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCounter.handle(counter);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Completable updateCount(final String id, final String count) {
    return Completable.fromCallable(new Callable<Void>() {
      @Override
      public Void call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCount.acquire();
        int _argIndex = 1;
        if (count == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, count);
        }
        _argIndex = 2;
        if (id == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, id);
        }
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return null;
        } finally {
          __db.endTransaction();
          __preparedStmtOfUpdateCount.release(_stmt);
        }
      }
    });
  }

  @Override
  public Single<List<Counter>> counters() {
    final String _sql = "SELECT * FROM counters";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createSingle(new Callable<List<Counter>>() {
      @Override
      public List<Counter> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCount = CursorUtil.getColumnIndexOrThrow(_cursor, "count");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final List<Counter> _result = new ArrayList<Counter>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Counter _item;
            final int _tmpCount;
            _tmpCount = _cursor.getInt(_cursorIndexOfCount);
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            _item = new Counter(_tmpCount,_tmpId,_tmpTitle);
            _result.add(_item);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
