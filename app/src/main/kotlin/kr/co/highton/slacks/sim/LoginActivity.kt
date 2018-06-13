package kr.co.highton.slacks.sim

import android.Manifest
import android.content.Intent
import android.widget.Toast
import com.google.android.gms.common.api.Api
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_login.*
import kr.co.highton.slacks.sim.R.id.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class LoginActivity : BaseActivity() {

    override var viewId: Int = R.layout.activity_login
    override var toolbarId: Int? = R.id.toolbar
    override fun onCreate() {
        val permissionlistener: PermissionListener = object : PermissionListener {
                override fun onPermissionGranted() { }

                override fun onPermissionDenied(deniedPermissions: java.util.ArrayList<String>?) {
                    Toast.makeText(this@LoginActivity, "권한 거부됨\\n\" ${deniedPermissions.toString()}", Toast.LENGTH_LONG).show()
                }
        }
        logo.bringToFront()
        login_btn.setOnClickListener {
//            if (id_tv.text.toString()=="1234"||pw_tv.text.toString()=="1234"){
//                startActivity (Intent(this@LoginActivity, MainActivity::class.java))
//            }
           Client.retrofitService.logIn(id_tv.text.toString(), pw_tv.text.toString()).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                    when (response!!.code()) {
                        200 -> {
                            finish()
                            startActivity (Intent(this@LoginActivity, MainActivity::class.java))
                        }
                        405 -> Toast.makeText(this@LoginActivity, "로그인 실패 : 아이디나 비번이 올바르지 않습니다", Toast.LENGTH_LONG).show()
                        500 -> Toast.makeText(this@LoginActivity, "로그인 실패 : 서버 오류", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Void>?, t: Throwable?) {

                }


            })
        }

        signup_go.setOnClickListener { startActivity(Intent(this@LoginActivity, SignUpActivity::class.java)) }
    }

}