<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\Hash;
use App\Models\User;

class DatabaseSeeder extends Seeder
{
    public function run(): void
    {
        // Create Admin User
        User::create([
            'name' => 'Admin User',
            'email' => 'admin@example.com',
            'password' => Hash::make('password'),
            'role' => 'admin',
        ]);

        // Create some dummy costumes
        \App\Models\Costume::create([
            'name' => 'Grey Luxury Suit',
            'description' => 'Premium wool suit',
            'price' => '80$/day',
            'image_url' => 'https://viz.example.com/suit.jpg',
            'is_available' => true
        ]);
    }
}
