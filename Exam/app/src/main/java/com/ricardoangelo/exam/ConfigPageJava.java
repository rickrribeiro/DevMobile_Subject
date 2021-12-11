package com.ricardoangelo.exam;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 5, 1},
   k = 1,
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"},
   d2 = {"Lcom/ricardoangelo/exam/ConfigPage;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "Landroid/widget/RadioGroup$OnCheckedChangeListener;", "()V", "<set-?>", "Landroid/content/SharedPreferences;", "sharedPreferences", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "onCheckedChanged", "", "p0", "Landroid/widget/RadioGroup;", "p1", "", "onClick", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}
)
public final class ConfigPageJava extends AppCompatActivity implements OnClickListener, OnCheckedChangeListener {
   @Nullable
   private SharedPreferences sharedPreferences;

   @Nullable
   public final SharedPreferences getSharedPreferences() {
      return this.sharedPreferences;
   }

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(R.layout.activity_config_page_java);
      ActionBar var10000 = this.getSupportActionBar();
      if (var10000 != null) {
         var10000.hide();
      }

      int valor = 0;
      this.sharedPreferences = this.getSharedPreferences("MyPreferences", 0);
      View var9 = this.findViewById(R.id.radio1);
      if (var9 == null) {
         throw new NullPointerException("null cannot be cast to non-null type android.widget.RadioGroup");
      } else {
         RadioGroup radio1 = (RadioGroup)var9;
         radio1.setOnCheckedChangeListener((OnCheckedChangeListener)this);
         SharedPreferences var10 = this.sharedPreferences;
         Intrinsics.checkNotNull(var10);
         valor = var10.getInt("radio1", 0);
         if (valor != 0) {
            radio1.check(valor);
         }

         var9 = this.findViewById(R.id.radio2);
         if (var9 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RadioGroup");
         } else {
            RadioGroup radio2 = (RadioGroup)var9;
            radio2.setOnCheckedChangeListener((OnCheckedChangeListener)this);
            var10 = this.sharedPreferences;
            Intrinsics.checkNotNull(var10);
            valor = var10.getInt("radio2", 0);
            if (valor != 0) {
               radio2.check(valor);
            }

            var9 = this.findViewById(R.id.radio3);
            if (var9 == null) {
               throw new NullPointerException("null cannot be cast to non-null type android.widget.RadioGroup");
            } else {
               RadioGroup radio3 = (RadioGroup)var9;
               radio3.setOnCheckedChangeListener((OnCheckedChangeListener)this);
               var10 = this.sharedPreferences;
               Intrinsics.checkNotNull(var10);
               valor = var10.getInt("radio3", 0);
               if (valor != 0) {
                  radio3.check(valor);
               }

               var9 = this.findViewById(R.id.radio4);
               if (var9 == null) {
                  throw new NullPointerException("null cannot be cast to non-null type android.widget.RadioGroup");
               } else {
                  RadioGroup radio4 = (RadioGroup)var9;
                  radio4.setOnCheckedChangeListener((OnCheckedChangeListener)this);
                  var10 = this.sharedPreferences;
                  Intrinsics.checkNotNull(var10);
                  valor = var10.getInt("radio4", 0);
                  if (valor != 0) {
                     radio4.check(valor);
                  }

                  CheckBox ligado = (CheckBox)this.findViewById(R.id.ligado);
                  ligado.setOnClickListener((OnClickListener)this);
                  Intrinsics.checkNotNullExpressionValue(ligado, "ligado");
                  SharedPreferences var10001 = this.sharedPreferences;
                  Intrinsics.checkNotNull(var10001);
                  ligado.setChecked(var10001.getBoolean("ligado", false));
               }
            }
         }
      }
   }

   public void onClick(@Nullable View p0) {
      SharedPreferences var10000 = this.sharedPreferences;
      Editor var3 = var10000 != null ? var10000.edit() : null;
      if (var3 == null) {
         throw new NullPointerException("null cannot be cast to non-null type android.content.SharedPreferences.Editor");
      } else {
         Editor sharedPreferencesEditor = var3;
         if (p0 != null) {
            if (p0.getId() == R.id.ligado && sharedPreferencesEditor != null) {
               sharedPreferencesEditor.putBoolean("ligado", ((CheckBox)p0).isChecked());
               sharedPreferencesEditor.commit();
            }
         }

      }
   }

   public void onCheckedChanged(@Nullable RadioGroup p0, int p1) {
      SharedPreferences var10000 = this.sharedPreferences;
      Editor var6 = var10000 != null ? var10000.edit() : null;
      if (var6 == null) {
         throw new NullPointerException("null cannot be cast to non-null type android.content.SharedPreferences.Editor");
      } else {
         Editor sharedPreferencesEditor = var6;
         if (p0 != null) {
            if (R.id.radio1 == p0.getId()) {
               Log.e("log2", "log2");
               if (sharedPreferencesEditor != null) {
                  sharedPreferencesEditor.putInt("radio1", p0.getCheckedRadioButtonId());
                  sharedPreferencesEditor.commit();
               }
            }
         }

         int var4;
         boolean var5;
         if (p0 != null) {
            if (R.id.radio2 == p0.getId()) {
               Log.e("log3", "log3");
               var4 = p0.getCheckedRadioButtonId();
               var5 = false;
               System.out.print(var4);
               if (sharedPreferencesEditor != null) {
                  sharedPreferencesEditor.putInt("radio2", p0.getCheckedRadioButtonId());
                  sharedPreferencesEditor.commit();
               }
            }
         }

         if (p0 != null) {
            if (p0.getId() == R.id.radio3) {
               Log.e("log4", "log4");
               var4 = p0.getCheckedRadioButtonId();
               var5 = false;
               System.out.print(var4);
               if (sharedPreferencesEditor != null) {
                  sharedPreferencesEditor.putInt("radio3", p0.getCheckedRadioButtonId());
                  sharedPreferencesEditor.commit();
               }
            }
         }

         if (p0 != null) {
            if (p0.getId() == R.id.radio4) {
               var4 = p0.getCheckedRadioButtonId();
               var5 = false;
               System.out.print(var4);
               if (sharedPreferencesEditor != null) {
                  sharedPreferencesEditor.putInt("radio4", p0.getCheckedRadioButtonId());
                  sharedPreferencesEditor.commit();
               }
            }
         }

      }
   }
}