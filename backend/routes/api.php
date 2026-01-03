<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\AuthController;
use App\Http\Controllers\CostumeController;
use App\Http\Controllers\ReservationController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
*/

// Public Routes
Route::post('/register', [AuthController::class, 'register']);
Route::post('/login', [AuthController::class, 'login']);
Route::get('/costumes', [CostumeController::class, 'index']);
Route::get('/costumes/{id}', [CostumeController::class, 'show']);

// Protected Routes (Sanctum)
Route::group(['middleware' => ['auth:sanctum']], function () {
    Route::post('/logout', [AuthController::class, 'logout']);
    Route::post('/reservations', [ReservationController::class, 'store']);
    Route::get('/my-reservations', [ReservationController::class, 'myReservations']);

    // Admin Routes
    Route::post('/costumes', [CostumeController::class, 'store']); // Add costume
    Route::put('/costumes/{id}', [CostumeController::class, 'update']);
    Route::delete('/costumes/{id}', [CostumeController::class, 'destroy']);
});
